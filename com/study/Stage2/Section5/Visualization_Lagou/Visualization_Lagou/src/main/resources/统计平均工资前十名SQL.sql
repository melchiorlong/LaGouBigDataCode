select count(distinct position_city)
from position_info_v2;

select position_city, position_salary
from position_info_v2
where position_salary like '%K';

select position_city, position_salary
from position_info_v2
where position_salary like '%薪';

select position_city, position_salary
from position_info_v2
where position_salary like '%天';

select position_city, position_salary
from position_info_v2
where position_salary = '面议';

########################################################################################################################################

# 分类汇总
select temp.position_city                             as city_name,
       round(sum(temp.avg) / count(position_city), 2) as avg_salary
from (
         select 1 as position_city, 1 as avg
         from dual
     ) temp
group by temp.position_city
order by avg_salary desc
limit 10;
########################################################################################################################################

# 结尾为K的

select position_city,
       position_salary,
       ((SUBSTRING_INDEX(position_salary, '-', 1)) +
        replace(SUBSTRING_INDEX(position_salary, '-', -1), 'K', '')) / 2 as avg
from position_info_v2
where 1 = 1
  and position_salary like '%K';

########################################################################################################################################

# 结尾为薪的
select tep.position_city,
       (tep.min + tep.max) * tep.month / 12 / 2 as avg
from (
         select position_salary,
                SUBSTRING_INDEX(position_salary, '-', 1) as min,
                SUBSTRING_INDEX(
                        replace(SUBSTRING_INDEX(replace(SUBSTRING_INDEX(position_salary, '-', -1), 'K', ''), '-', -1),
                                '薪', ''), '·', 1)        as max,
                SUBSTRING_INDEX(
                        replace(SUBSTRING_INDEX(replace(SUBSTRING_INDEX(position_salary, '-', -1), 'K', ''), '-', -1),
                                '薪', ''), '·', -1)       as month
         from position_info_v2
         where 1 = 1
           and position_city = '牡丹江'
           and position_salary like '%薪') tep;



########################################################################################################################################

# 结尾为天的
select position_city,
       ((SUBSTRING_INDEX(position_salary, '-', 1)) + replace(SUBSTRING_INDEX(position_salary, '-', -1), '/天', '')) / 2 *
       21.75 / 1000 as avg
from position_info_v2
where 1 = 1
  and position_city = '北京'
  and position_salary like '%天';



########################################################################################################################################

# 合并数据
select temp.position_city                             as positionCity,
       round(sum(temp.avg) / count(position_city), 2) as avgSalary
from (
         select position_city,
                ((SUBSTRING_INDEX(position_salary, '-', 1)) +
                 replace(SUBSTRING_INDEX(position_salary, '-', -1), 'K', '')) / 2 as avg
         from position_info_v2
         where position_salary like '%K'
         union
         select tep.position_city,
                (tep.min + tep.max) * tep.month / 12 / 2 as avg
         from (
                  select position_city,
                         position_salary,
                         SUBSTRING_INDEX(position_salary, '-', 1)                     as min,
                         SUBSTRING_INDEX(replace(SUBSTRING_INDEX(
                                                         replace(SUBSTRING_INDEX(position_salary, '-', -1), 'K', ''),
                                                         '-', -1), '薪', ''), '·', 1)  as max,
                         SUBSTRING_INDEX(replace(SUBSTRING_INDEX(
                                                         replace(SUBSTRING_INDEX(position_salary, '-', -1), 'K', ''),
                                                         '-', -1), '薪', ''), '·', -1) as month
                  from position_info_v2
                  where position_salary like '%薪') tep
         union
         select position_city,
                ((SUBSTRING_INDEX(position_salary, '-', 1)) +
                 replace(SUBSTRING_INDEX(position_salary, '-', -1), '/天', '')) / 2 * 21.75 / 1000 as avg
         from position_info_v2
         where position_salary like '%天'
     ) temp
group by positionCity
order by avgSalary desc
limit 10



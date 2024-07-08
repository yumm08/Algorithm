-- 코드를 작성해주세요

select e.ID
from ECOLI_DATA e
join ECOLI_DATA p on p.ID = e.PARENT_ID
join ECOLI_DATA pp on pp.ID = p.PARENT_ID
where pp.PARENT_ID is null and p.ID is not null
order by e.ID asc;
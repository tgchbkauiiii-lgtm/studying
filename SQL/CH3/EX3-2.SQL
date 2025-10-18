-- 1
SELECT *
  FROM 都道府県
 WHERE 都道府県名 LIKE '%川'
-- 2
SELECT *
  FROM 都道府県
 WHERE 都道府県名 LIKE '%島%'
--  3
SELECT *
  FROM 都道府県
 WHERE 都道府県名 LIKE '愛%'
--  4
SELECT *
  FROM 都道府県
 WHERE 都道府県名 LIKE 県庁所在地
--  5
SELECT *
  FROM 都道府県
 WHERE 都道府県名 NOT LIKE 県庁所在地
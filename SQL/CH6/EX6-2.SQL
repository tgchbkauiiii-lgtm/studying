-- 1
SELECT COUNT(*) AS 入室中の社員数
  FROM 入退室管理
 WHERE 退室 IS NULL
-- 2
SELECT 社員名,
       COUNT(*) AS 入室回数
  FROM 入退室管理
 GROUP BY 社員名
 ORDER BY 入室回数 DESC
-- 3
SELECT 事由区分, 
       COUNT(*) AS 入室回数
  FROM 入退室管理
 GROUP BY 事由区分
-- 4
SELECT 社員名,COUNT(*) AS 入室回数
  FROM 入退室管理
 GROUP BY 社員名
 ORDER BY 入室回数 DESC

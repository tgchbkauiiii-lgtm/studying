-- 1
SELECT 社員番号,S.名前,B.名前 AS 部署名
  FROM 社員 AS S
  JOIN 部署 AS B
    ON S.部署ID = B.部署ID
-- 2
SELECT A.社員番号, A.名前,B.名前 AS 上司名
  FROM 社員 AS A
  JOIN 社員 AS B
    ON A.上司ID = B.社員番号
-- 3
SELECT 社員番号,社員.名前,部署.名前 AS 部署名,支店.名前 AS 勤務地
  FROM 社員
  JOIN 部署
    ON 社員.部署ID = 部署.部署ID
  JOIN 支店
    ON 社員.勤務地ID = 支店.支店ID
-- 4
SELECT 支店.支店ID AS 支店コード,
       支店.名前 AS 支店名,
       社員.名前 AS 支店長名,
       (SELECT COUNT(*)
          FROM 社員
         WHERE 社員.勤務地ID = 支店.支店ID) AS 社員数
  FROM 支店
  JOIN 社員
    ON 支店.支店長ID = 社員.社員番号
-- 5
SELECT 社員番号,社員.名前,支店.名前 AS 本人勤務地,
       支店.名前 AS 上司勤務地
  FROM 社員
  JOIN 支店
    ON 社員.勤務地ID = 支店.支店ID
 WHERE 社員.勤務地ID
       <>
       (SELECT B.勤務地ID
          FROM 社員 AS A
          JOIN 社員 AS B
            ON A.上司ID = B.社員番号)
-- 1
SELECT * FROM 注文履歴
 ORDER BY 注文番号 ASC
       ,注文枝番 ASC
-- 2
SELECT 商品名 
  FROM 注文履歴
 WHERE 日付 LIKE "2024-01-%"
 ORDER BY 商品名
--  3
SELECT 注文番号,注文枝番,注文金額
  FROM 注文履歴
 WHERE 分類 = 1
 ORDER BY 注文金額 ASC 
 LIMIT 4
-- 4
SELECT 日付,商品名,単価,数量,注文金額
  FROM 注文履歴
 WHERE 分類 = 3
   AND 数量 >= 2
 ORDER BY 日付 ASC
       ,数量 DESC
-- 5
SELECT 分類,商品名,サイズ,単価
  FROM 注文履歴
 WHERE 分類 = 1
 UNION
SELECT 分類,商品名,NULL,単価
  FROM 注文履歴
 WHERE 分類 = 2
 UNION
SELECT 分類,商品名,NULL,単価
  FROM 注文履歴
 WHERE 分類 = 3
 ORDER BY 分類,商品名

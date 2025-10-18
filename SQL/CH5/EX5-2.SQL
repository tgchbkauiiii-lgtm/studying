-- 1
UPDATE 回答者
   SET 国名 = 
  CASE WHEN SUBSTRING(メールアドレス,-2,2) = 'jp' THEN '日本'
       WHEN SUBSTRING(メールアドレス,-2,2) = 'uk' THEN 'イギリス'   
       WHEN SUBSTRING(メールアドレス,-2,2) = 'cn' THEN '中国'
       WHEN SUBSTRING(メールアドレス,-2,2) = 'fr' THEN 'フランス'
       WHEN SUBSTRING(メールアドレス,-2,2) = 'vn' THEN 'ベトナム'
-- 2
SELECT メールアドレス,住居,年齢
  FROM 回答者
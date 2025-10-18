-- LIST7-9
SELECT * FROM 家計簿アーカイブ
 WHERE 費目 IN (SELECT 費目 FROM 家計簿アーカイブ
                 WHERE 費目 IS NOT NULL)
-- LIST7-10
SELECT * FROM 家計簿アーカイブ
 WHERE 費目 IN (SELECT COALESCE(費目, '不明') FROM 家計簿アーカイブ)
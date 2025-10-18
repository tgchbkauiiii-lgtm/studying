-- 1
UPDATE 試験結果 
   SET 午後１ = 平均点 * 4 - (午前 + 午後２ + 論述)
 WHERE 受験者ID = 'SW1046';

UPDATE 試験結果 
   SET 論述 = (平均点 * 4) - (午前 + 午後1 + 午後2)
 WHERE 受験者ID = 'SW1350'

UPDATE 試験結果 
   SET 午前 = (平均点 * 4) - (午後1 + 午後2 + 36)
 WHERE 受験者ID = 'SW1877'
-- 2
SELECT 受験者ID
  FROM 試験結果
 WHERE 午前 >= 60
   AND (午後1 + 午後2) >= 120
   AND 論述 >= (午前 + 午後1 + 午後2) * 0.3

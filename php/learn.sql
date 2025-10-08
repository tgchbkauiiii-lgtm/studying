P145
select*from items;
-- itemsの内容を表示

P146
insert into items set id=100, name='商品100';
-- itemsにデータをぶち込む

P149
create table my_items (id int, item_name text, price int);
-- my_itemsテーブルを作成

P150
insert into my_items set id=1, item_name='いちご', price=200;
-- my_itemsにデータぶち込み

P152
update my_items set price=180 where id=1;
-- my_itemsの内容、id1のpriceを180円に

P153
delete from my_items where id=1;
-- my_itemsのid1のデータを削除

P154
select id,item_name from my_items where id=1;
-- my_itemsからid,item_nameを検索して表示

P157
insert into my_items set id=1,item_name='いちご',price=180;
insert into my_items set id=1,item_name='りんご',price=90;
-- プライマリーに設定したid1に違うデータを挿入することはできない
insert into my_items set id=null,item_name='りんご';
-- プライマリーキーのidをnullにすることもできない

P160
insert into my_items set item_name='りんご',price=90;
-- オートインクリメントをオンにすればこれでぶち込める

P161
insert into my_items set item_name='バナナ',price=120;
insert into my_items set item_name='ブルーベリー',price=200;
-- バナナとブルーベリーも追加

P165
select*from my_items where price>180;
select*from my_items where price<=180;
select*from my_items where price>=180;
select*from my_items where id<>1;
                     
P166
select*from my_items where keyword like '%甘い%';
-- '甘い'を含むものを検索
select*from my_items where keyword like '赤い%';
-- '赤い'から始まる文言を含むものを検索

P167
select*from my_items where price>=50 and price<=150;
-- 二つの条件を両方満たすものを検索
select*from my_items where id=1 or id=3;
-- 二つの条件のどちらかを満たすものを検索
select*from my_items where (id=1 or id=3) and price<150 andkeyword like '%甘い%';
-- 三つの条件をすべて満たすものを検索（）に注意

P169
select*from my_items order by id ASC;
-- id昇順で表示する命令

P170
select*from my_items order by id desc;
-- id降順で並べ替え
select*from my_items where price<=180 order by price;
-- whereと組み合わせるときはorderが後。180円以下で安い順に並べる

P172
-- my_itemsをクリックした状態で構造タブから新しいカラムを作成。クエリを書くか書き込みたい部分をダブルクリックで編集。

P174
select sum(price) from my_items;
-- すべての商品の総額を計算して表示

select avg(price) from my_items;
-- すべての商品の平均価格を計算して

P157
select max(price) from my_items;
-- 価格最大のものを表示
select min(price) from my_items;
-- 価格最小のものを表示
select count(id) from my_items;
-- idの件数を表示
select avg(price) from my_items;
-- 価格の平均を表示

P178
insert into makers set name='山田さん',address='東京都港区',tel='000-111-2222';
insert into makers set name='斎藤さん',address='北海道小樽市',tel='111-222-3333';
insert into makers set name='川上さん',address='神奈川県横浜市',tel='222-333-4444';

P179
select maker_id from my_items where id=1;

P184
INSERT INTO `carts` SET id=1,item_id=1,count=5;
INSERT INTO `carts` SET id=2,item_id=2,count=3;
INSERT INTO `carts` SET id=3,item_id=3,count=1;
INSERT INTO `carts` SET id=4,item_id=1,count=3;
INSERT INTO `carts` SET id=5,item_id=3,count=2;
INSERT INTO `carts` SET id=6,item_id=1,count=2;

select my_items.item_name,carts.count from my_items,carts where my_items.id=carts.item_id;
-- item_nameとcountを並べて表示idとitem_idでリレーション

select sum(count) from carts;
-- 販売数の合計値を表示

P185
select item_id,sum(count) from carts group by item_id;
-- item_idごとに販売数を表示

select i.item_name,sum(c.count) from my_items i,carts c where i.id=c.item_id group by c.item_id;
-- item_nameと販売数を表示

P186
select i.item_name,sum(c.count) from my_items i,carts c where i.id=c.item_id group by i.id;

P187
select i.item_name,sum(count)from my_items i left join carts c on i.id=c.item_id group by i.id;

P188
select distinct item_id from carts;

P189
select * from  my_items where price between 50 and 149;

select * from my_items where id in(1,3);

P190
select * from carts limit 2;

select * from carts limit 1,2;

P191
select i.item_name,sum(c.count) as sales_count from my_items i,carts c where i.id=c.item_id group by c.item_id;

P192
select
    m.name,
    i.item_name,
    sum(c.count) as sales_count
from
    makers m,
    my_items i left join carts c on i.id=c.item_id
where
    m.id=i.maker_id
group by
    c.item_id
order by
    sales_count desc;
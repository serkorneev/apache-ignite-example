CREATE KEYSPACE IF NOT EXISTS serkorneev WITH replication = {'class':'SimpleStrategy','replication_factor':'1'};

USE serkorneev;

CREATE TABLE product (
  uniq_id text PRIMARY KEY,
  sku text,
  name_title text,
  description text,
  list_price text,
  sale_price text,
  category text,
  category_tree text,
  average_product_rating text,
  product_url text,
  product_image_urls text,
  brand text,
  total_number_reviews text,
  Reviews text
);

COPY product (uniq_id,sku,name_title,description,list_price,sale_price,category,category_tree,average_product_rating,product_url,product_image_urls,brand,total_number_reviews,Reviews) FROM 'jcpenney_com-ecommerce_sample.csv' WITH HEADER=TRUE;

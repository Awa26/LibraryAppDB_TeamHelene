SELECT COUNT(id) from users;
-- 1855
SELECT COUNT(DISTINCT id) from users;

select * from users;


select name, id, name, isbn, year, author,  description from books
where name = 'Clean Code';


select distinct name from books
where name = 'Marko Petrovic - SR';


select name from book_categories;


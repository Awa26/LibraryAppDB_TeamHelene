SELECT COUNT(id) from users;
-- 1855
SELECT COUNT(DISTINCT id) from users;

select * from users;


select name, id, name, isbn, year, author,  description from books
where name = 'Clean Code';


select distinct name from books
where name = 'Marko Petrovic - SR';


select name from book_categories;

select bb.borrowed_date from users u
inner join book_borrow bb on u.id = bb.user_id
inner join books b on bb.book_id = b.id
where full_name='Test Student 33'
order by 1 desc;

select full_name,b.name,bb.borrowed_date, bb.returned_date from users u
inner join book_borrow bb on u.id = bb.user_id
inner join books b on bb.book_id = b.id
where full_name='Test Student 33'
order by 3 desc;

select * from book_borrow
where is_returned = 0;

select distinct * from (select * from book_borrow
where is_returned = 0) t
join users u on t.user_id = u.id;




SELECT COUNT(id) from users;
SELECT COUNT(DISTINCT id) from users;

SELECT * from users;

SELECT count(*) from book_borrow
where is_returned=0;

select is_returned from book_borrow
join users u on u.id = book_borrow.user_id
where full_name = 'Test Student 33'
order by borrowed_date desc;

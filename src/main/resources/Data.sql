
INSERT INTO users (id, username, password, role, created_at)
VALUES (1, 'admin', '$2a$10$S5dJqnQzFdyTYYvVDC8YL.qG4QEzyWRs666Q4fpx3vFugkWZZ5m5S', 'ADMINISTRATORS', NOW());


INSERT INTO publisher (id, name, address, contact_email, contact_phone)
VALUES (1, 'Default Publisher', '123 Main Street', 'publisher@example.com', '0123456789');


INSERT INTO author (id, name, bio, date_of_birth)
VALUES (1, 'Jane Austen', 'Classic English novelist', '1775-12-16');

INSERT INTO category (id, name, parent_id)
VALUES (1, 'Fiction', NULL);

INSERT INTO book (id, language, isbn, edtion, summary, cover_image_url, is_borrowed, publication_year, publisher_id)
VALUES (1, 'English', '123-456-789', '1st', 'A classic novel.', 'http://example.com/cover.jpg', false, 1813, 1);

INSERT INTO book_authors (id, book_id, author_id)
VALUES (1, 1, 1);

INSERT INTO book_categories (id, book_id, category_id)
VALUES (1, 1, 1);

INSERT INTO member (username, name, address, email, phone, created_at)
VALUES ('user1', 'Ali Hassan', '456 Elm St', 'ali@example.com', '01012345678', NOW());

INSERT INTO borrowing_transaction (id, borrow_date, due_date, return_date, book_id, username)
VALUES (1, NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), NULL, 1, 'user1');

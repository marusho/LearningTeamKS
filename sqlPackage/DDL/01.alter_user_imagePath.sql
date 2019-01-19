ALTER TABLE public.users add column image_path text;
COMMENT ON COLUMN users.image_path IS '画像のURL	画面にイメージを表示する際にイメージパス';
INSERT INTO parking_spot (identification, status) 
SELECT 'VAGA-' || LPAD(s.i::text, 2, '0'), 'FREE'
FROM generate_series(1, 50) s(i)
ON CONFLICT DO NOTHING;

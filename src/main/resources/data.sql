INSERT INTO parking_spot (id, identification, status) 
SELECT 
    s.i, 
    'VAGA-' || LPAD(s.i::text, 2, '0'), 
    'FREE'
FROM generate_series(1, 50) s(i)
ON CONFLICT (id) DO NOTHING;

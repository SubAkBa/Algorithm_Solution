SELECT DISTINCT athlete_id
FROM records
WHERE EXISTS (
    SELECT 1
    FROM events
    WHERE sport = 'Golf'
    AND events.id = records.event_id
);
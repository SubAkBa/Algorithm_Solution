-- @ss.idx: 6
-- @ss.level: 3
-- @ss.title: 멘토링 짝꿍 리스트
-- @ss.slug: mentor-mentee-list
-- @ss.category: JOIN/UNION
-- @ss.note:

SELECT
    e1.employee_id AS mentee_id,
    e1.name        AS mentee_name,
    e2.employee_id AS mentor_id,
    e2.name        AS mentor_name
FROM employees e1
LEFT JOIN employees e2 ON e2.department != e1.department
    AND e2.join_date <= DATE_SUB('2021-12-31', INTERVAL 2 YEAR)
WHERE e1.join_date >= DATE_SUB('2021-12-31', INTERVAL 3 MONTH)
ORDER BY mentee_id, mentor_id;

SELECT avg(salary) FROM projects p
INNER JOIN developer_project dp ON dp.project_id = p.project_id
INNER JOIN developers d ON d.developer_id = dp.developer_id
WHERE p.cost = (SELECT min(cost) FROM projects);
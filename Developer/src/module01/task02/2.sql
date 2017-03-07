SELECT project_name, sum(salary) FROM projects p
INNER JOIN developer_project a ON p.project_id = a.project_id
INNER JOIN developers d ON a.developer_id = d.developer_id
GROUP BY project_name
ORDER BY sum(salary) DESC
LIMIT 1;
SELECT skill_name, sum(salary) FROM developers d
  INNER JOIN developer_skill s ON d.developer_id = s.developer_id
  INNER JOIN skills sk ON s.skill_id = sk.skill_id
WHERE skill_name = "Java";
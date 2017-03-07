SELECT companies.company_name, customers.customer_name, min_cost
FROM (SELECT MIN(cost) as min_cost, projects.company_id as com_id
      FROM projects
      GROUP BY projects.company_id) as min_table
  INNER JOIN projects ON projects.cost = min_cost AND projects.company_id = com_id
  INNER JOIN companies ON projects.company_id = companies.company_id
  INNER JOIN customers ON projects.customer_id = customers.customer_id;
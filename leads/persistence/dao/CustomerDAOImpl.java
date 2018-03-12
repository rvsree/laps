package com.mortgage.leads.persistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.mortgage.leads.persistence.domain.Customer;
import com.mortgage.leads.persistence.domain.Lead;
import com.mortgage.leads.persistence.helper.SqlQueryManager;
import com.mortgage.leads.utils.config.DataSourceConfig;
import com.mortgage.leads.utils.exception.DAOException;

@Component
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	protected DataSourceConfig dataSource;

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/*
	 * @Autowired protected DataSource dataSource;
	 * 
	 * public DataSource getDataSource() { DriverManagerDataSource dataSource = new
	 * DriverManagerDataSource(); return dataSource; }
	 */

	private CustomerDAOImpl() {
	}

	@Override
	public Customer getLeadById(String sqlCustomer, String Id) {
		Customer customer = this.jdbcTemplate.queryForObject(sqlCustomer, new Object[] { 1212L },
				new RowMapper<Customer>() {
					public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
						Customer customer = new Customer();
						customer.setFirstName(rs.getString("firstName"));
						customer.setLastName(rs.getString("lastName"));
						return customer;
					}
				});
		return customer;
	}

	@Override
	public List<Customer> getLeads(String sqlCustomer) {
		return this.jdbcTemplate.query(sqlCustomer, new CustomerMapper());
	}
	
	@Override
	public Lead getLeadStatus(String sqlLead, String Id) {
		Lead lead = this.jdbcTemplate.queryForObject(sqlLead, new Object[] { 1212L }, new RowMapper<Lead>() {
			public Lead mapRow(ResultSet rs, int rowNum) throws SQLException {
				Lead lead = new Lead();
				lead.setFirstName(rs.getString("firstName"));
				lead.setLastName(rs.getString("lastName"));
				return lead;
			}
		});
		return lead;
	}

	@Override
	public void saveLead(Customer customer) throws DAOException {
		try {
			Map<String, Comparable> namedParameters = new HashMap();
			namedParameters.put("customerId", customer.getCustomerId());
			namedParameters.put("firstName", customer.getFirstName());
			namedParameters.put("lastName", customer.getLastName());
			namedParameters.put("dateOfBirth", customer.getDateOfBirth());			
			namedParameters.put("age", customer.getAge());
			namedParameters.put("gender", customer.getGender());
			namedParameters.put("maritalStatus", customer.getMaritalStatus());
			namedParameters.put("customerType", customer.getCustomerType());
			namedParameterJdbcTemplate.update(SqlQueryManager.getCustomerSql(), namedParameters);
		} catch (Exception ex) {
			System.out.println("DAO: save error: " + ex.getMessage());
			throw new DAOException("Exception occured at CustomerDAOImpl, saveCustomer Failed: " + ex.getMessage());
		} finally {
			try {
				if (!jdbcTemplate.getDataSource().getConnection().isClosed())
					jdbcTemplate.getDataSource().getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static final class CustomerMapper implements RowMapper<Customer> {
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setFirstName(rs.getString("firstName"));
			customer.setLastName(rs.getString("lastName"));
			return customer;
		}
	}

	public int[] batchUpdateCustomers(final List<Customer> customers) {
		return this.jdbcTemplate.batchUpdate("Update Customer set firstName = ?, lastName = ? where customerId = ?",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, customers.get(i).getFirstName());
						ps.setString(2, customers.get(i).getLastName());
						ps.setString(3, customers.get(i).getCustomerId());
					}

					public int getBatchSize() {
						return customers.size();
					}
				});
	}

	public int[] batchInsertCustomers(final List<Customer> customers) {
		return this.jdbcTemplate.batchUpdate("Insert Customer set firstName = ?, lastName = ? where customerId = ?",
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, customers.get(i).getFirstName());
						ps.setString(2, customers.get(i).getLastName());
						ps.setString(3, customers.get(i).getCustomerId());
					}

					public int getBatchSize() {
						return customers.size();
					}
				});
	}

}

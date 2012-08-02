package uk.org.datalink.MDR.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import uk.org.datalink.MDR.domain.Address;





@SuppressWarnings("deprecation")
public class JDBCAddressDao extends SimpleJdbcDaoSupport implements AddressDao{
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

	
	@SuppressWarnings("unchecked")
	public ArrayList<Address> getAddressList(){
		logger.info("Getting Address list!");
        ArrayList<Address> addresslist = (ArrayList) getSimpleJdbcTemplate().query(
                "select id, address1, address2, town, region, postcode from country", new AddressMapper());
        return addresslist;
	}
	public void updateAddress(Address addObj){
		logger.info("Updating address: " + addObj.getId());
        int count = getSimpleJdbcTemplate().update(
            "update address set address1 = :address1, address2 = :address2, town = :town, region = :region, " +
            "postcode = :postcode where id = :id",
            new MapSqlParameterSource().addValue("address1", addObj.getAddress1())
                .addValue("address2", addObj.getAddress2())
                .addValue("town", addObj.getTown())
                .addValue("region", addObj.getRegion())
                .addValue("postcode", addObj.getPostcode())
                .addValue("id", addObj.getId()));
        logger.info("Rows affected: " + count);
	}
	public void saveAddress(Address addObj){
		logger.info("createAddress, createdBy= " + addObj.getAddress1());
		JdbcTemplate insert = getJdbcTemplate();
		int count = insert.update("INSERT INTO address (address1,address2,town,region,postcode) VALUES(?,?,?,?,?)",
		new Object[] { addObj.getAddress1(), addObj.getAddress2(), addObj.getTown(), addObj.getRegion(), addObj.getPostcode()});
        logger.info("Rows affected: " + count);
	}
	public int createAddress(Address addObj){
		logger.info("createAddress, createdBy= " + addObj.getAddress1());
		JdbcTemplate insert = getJdbcTemplate();
		int count = insert.update("INSERT INTO address (address1,address2,town,region,postcode) VALUES(?,?,?,?,?)",
		new Object[] { addObj.getAddress1(), addObj.getAddress2(), addObj.getTown(), addObj.getRegion(), addObj.getPostcode()});
        logger.info("Rows affected: " + count);
        String addNoSQL = "select last_value from seq_add;" ;
        int addNo = insert.queryForInt(addNoSQL,null);
        return addNo;
	}
	public List<Address> getAddress(int id){
		logger.info("get Address, id= " + id);
		JdbcTemplate insert = getJdbcTemplate();
		ArrayList<Address> addresslist = (ArrayList<Address>) getSimpleJdbcTemplate().query(
                "select id, address1, address2,town,region,postcode from country where id=" + id, 
                new AddressMapper());
		return addresslist;
	}
	public void deleteAllAddress(){
		logger.info("delete Address Records");
		JdbcTemplate insert = getJdbcTemplate();
		int count = insert.update("DELETE FROM address");
        logger.info("Rows affected: " + count);
	}
	public void deleteAddress(int id){
		logger.info("delete address, id= " + id);
		JdbcTemplate insert = getJdbcTemplate();
		int count = insert.update("DELETE FROM address WHERE ID=" + id);
        logger.info("Rows affected: " + count);
	}
	
	private static class AddressMapper implements ParameterizedRowMapper<Address> {

        public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Address obj = new Address();
            obj.setId(rs.getInt("id"));
            obj.setAddress1(rs.getString("address1"));
            obj.setAddress2(rs.getString("address2"));
            obj.setTown(rs.getString("town"));
            obj.setRegion(rs.getString("region"));
            obj.setPostcode(rs.getString("postcode"));
            return obj;
        }

    }

}

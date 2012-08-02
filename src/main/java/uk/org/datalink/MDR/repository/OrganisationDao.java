package uk.org.datalink.MDR.repository;

import java.util.ArrayList;
import java.util.List;

import uk.org.datalink.MDR.domain.Organisation;

public interface OrganisationDao {
	public ArrayList<Organisation> getOrganisationList();
	public void updateOrganisation(Organisation cntObj);
	public int createOrganisation(Organisation cntObj);
	public List<Organisation> getOrganisation(int id);
	public void deleteAllOrganisations();
	public void deleteOrganisation(int id);

}

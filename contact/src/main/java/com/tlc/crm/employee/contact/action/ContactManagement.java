package com.tlc.crm.employee.contact.action;

import com.tlc.commons.json.JsonObject;
import com.tlc.crm.employee.contact.api.ContactManager;
import com.tlc.crm.employee.common.action.secure.CrmConfigAction;
import com.tlc.crm.employee.common.config.ConfigManager;
import com.tlc.crm.employee.contact.api.Contact;
import com.tlc.web.WebAction;

import java.util.Collection;

/**
 * @author Abishek
 * @version 1.0
 */
@WebAction(path = "/contact/mgmt")
public class ContactManagement extends CrmConfigAction<Contact>
{
    @Override
    public JsonObject construct(Contact employee) {
        return null;
    }

    @Override
    public ConfigManager<Contact> getConfigManager()
    {
        return ContactManager.getInstance();
    }

    @Override
    public Contact construct(JsonObject jsonObject)
    {
        return null;
    }

    @Override
    public Collection<Contact> constructArray(JsonObject jsonObject) {
        return null;
    }
}
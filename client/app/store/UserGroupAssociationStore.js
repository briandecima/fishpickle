/*
 * File: app/store/UserGroupAssociationStore.js
 *
 * This file was generated by Sencha Designer version 2.0.0.
 * http://www.sencha.com/products/designer/
 *
 * This file requires use of the Sencha Touch 2.0.x library, under independent license.
 * License of Sencha Designer does not include license for Sencha Touch 2.0.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('fishpickle.store.UserGroupAssociationStore', {
    extend: 'Ext.data.Store',
    requires: [
        'fishpickle.model.UserGroupAssociations'
    ],

    config: {
        model: 'fishpickle.model.UserGroupAssociations',
        storeId: 'UserGroupAssociationStore',
        proxy: {
            type: 'rest',
            url: 'rest/userGroupAssociation',
            reader: {
                type: 'json'
            }
        }
    }
});
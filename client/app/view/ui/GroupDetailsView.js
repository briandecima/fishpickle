/*
 * File: app/view/ui/GroupDetailsView.js
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

Ext.define('fishpickle.view.ui.GroupDetailsView', {
    extend: 'Ext.form.Panel',

    config: {
        itemId: '',
        items: [
            {
                xtype: 'titlebar',
                docked: 'top',
                id: 'groupDetails',
                title: 'Group Details',
                items: [
                    {
                        xtype: 'button',
                        id: 'groupDetailsBackButton',
                        ui: 'back',
                        text: 'Back'
                    },
                    {
                        xtype: 'button',
                        id: 'saveGroupButton',
                        itemId: 'saveGroupButton',
                        ui: 'action',
                        text: 'Save',
                        align: 'right'
                    }
                ]
            },
            {
                xtype: 'textfield',
                id: 'groupNameField',
                label: 'Name',
                labelAlign: 'top',
                name: 'name'
            },
            {
                xtype: 'textareafield',
                id: 'groupDescriptionField',
                label: 'Description',
                labelAlign: 'top',
                name: 'description'
            },
            {
                xtype: 'togglefield',
                id: 'isPrivateToggle',
                label: 'Private',
                name: 'isPrivate',
                value: 1
            }
        ]
    }

});
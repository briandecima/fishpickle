/*
 * File: app/view/MyGroupsView.js
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

Ext.define('fishpickle.view.MyGroupsView', {
    extend: 'Ext.Panel',
    alias: 'widget.mygroupsview',

    config: {
        baseCls: 'x-form',
        layout: {
            type: 'fit'
        },
        items: [
            {
                xtype: 'titlebar',
                docked: 'top',
                id: 'myGroupsToolbar',
                title: 'My Groups',
                items: [
                    {
                        xtype: 'button',
                        id: 'createGroup',
                        ui: 'action',
                        iconAlign: 'center',
                        text: 'New',
                        align: 'right'
                    }
                ]
            },
            {
                xtype: 'list',
                id: 'myGroupsList',
                ui: 'round',
                emptyText: 'You are not a member of any groups.',
                itemTpl: [
                    '<div>{name}</div>'
                ],
                store: 'MyGroupsStore',
                onItemDisclosure: true
            }
        ]
    }

});
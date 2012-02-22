/*
 * File: app/view/ui/HomeView.js
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

Ext.define('fishpickle.view.ui.HomeView', {
    extend: 'Ext.Panel',

    config: {
        ui: 'dark',
        layout: {
            type: 'fit'
        },
        items: [
            {
                xtype: 'titlebar',
                docked: 'top',
                id: 'TopToolbar',
                title: 'My Groups'
            },
            {
                xtype: 'list',
                id: 'MyGroupsList',
                ui: 'round',
                emptyText: 'You are not a member of any groups.',
                itemTpl: [
                    '<div>{name}</div>'
                ],
                store: 'MyJsonStore',
                onItemDisclosure: true
            }
        ]
    }

});
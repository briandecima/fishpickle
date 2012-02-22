/*
 * File: app/view/ui/MainView.js
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

Ext.define('fishpickle.view.ui.MainView', {
    extend: 'Ext.tab.Panel',
    requires: [
        'fishpickle.view.HomeView',
        'fishpickle.view.SearchView',
        'fishpickle.view.CreateGroupView'
    ],

    config: {
        tabBar: {
            docked: 'bottom'
        },
        items: [
            {
                xtype: 'container',
                layout: {
                    type: 'fit'
                },
                title: 'Home',
                iconCls: 'home',
                items: [
                    {
                        xtype: 'homeview',
                        id: 'HomeGroup'
                    }
                ]
            },
            {
                xtype: 'container',
                cls: [
                    'search'
                ],
                layout: {
                    type: 'fit'
                },
                title: 'Search',
                iconCls: 'search',
                items: [
                    {
                        xtype: 'searchview',
                        itemId: 'SearchGroup'
                    }
                ]
            },
            {
                xtype: 'container',
                layout: {
                    type: 'fit'
                },
                title: 'Create',
                iconCls: 'add',
                items: [
                    {
                        xtype: 'creategroupview',
                        itemId: 'CreateGroup'
                    }
                ]
            },
            {
                xtype: 'container',
                layout: {
                    type: 'fit'
                },
                title: 'Settings',
                iconCls: 'settings'
            }
        ]
    }

});
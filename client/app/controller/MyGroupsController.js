/*
 * File: app/controller/MyGroupsController.js
 *
 * This file was generated by Sencha Designer version 2.0.0.
 * http://www.sencha.com/products/designer/
 *
 * This file requires use of the Sencha Touch 2.0.x library, under independent license.
 * License of Sencha Designer does not include license for Sencha Touch 2.0.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * You should implement event handling and custom methods in this
 * class.
 */

Ext.define('fishpickle.controller.MyGroupsController', {
    extend: 'Ext.app.Controller',

    config: {
        control: {
            "#MainAppView": {
                activeitemchange: 'onPanelActiveItemChange'
            },
            "#myGroupsContainer": {
                activate: 'onContainerActivate'
            }
        }
    },

    onPanelActiveItemChange: function(container, value, oldValue, options) {

        //TODO make the id in the url dynamic
        if (fishpickle.baseURL) {
            //console.log("Panel Active Item Change " + fishpickle.baseURL);
            Ext.getStore("MyGroupsStore").getProxy().setUrl(fishpickle.baseURL + "rest/user/1/groups");
            Ext.getStore("MyGroupsStore").load();  
        }
    },

    onContainerActivate: function(container, newActiveItem, oldActiveItem, options) {

        //TODO make the id in the url dynamic
        if (fishpickle.baseURL) {
            //console.log("Container Activate " + fishpickle.baseURL);
            Ext.getStore("MyGroupsStore").getProxy().setUrl(fishpickle.baseURL + "rest/user/1/groups");
            Ext.getStore("MyGroupsStore").load();  
        }
    }

});
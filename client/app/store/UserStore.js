/*
 * File: app/store/UserStore.js
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

Ext.define('fishpickle.store.UserStore', {
    extend: 'fishpickle.store.base.UserStore',
    alias: 'widget.userStore',

    constructor: function(cfg) {

        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({}, cfg)]);
    }

});
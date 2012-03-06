/*
 * File: app/controller/UserController.js
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

Ext.define('fishpickle.controller.UserController', {
    extend: 'Ext.app.Controller',

    config: {
        refs: {
            mainAppView: 'mainappview',
            registrationView: {
                selector: 'registrationview',
                xtype: 'registrationview'
            }
        },

        control: {
            "#saveSettingsButton": {
                tap: 'onButtonTap'
            },
            "#RegistrationBackButton": {
                tap: 'onRegistrationBackButtonTap'
            },
            "#RegistrationSaveButton": {
                tap: 'onRegistrationSaveButtonTap'
            },
            "#registrationitem": {
                activate: 'onRegistrationViewActivate'
            }
        }
    },

    onButtonTap: function(button, e, options) {
        console.log('Saving the user settings');
    },

    onRegistrationBackButtonTap: function(button, e, options) {
        this.getMainAppView().setActiveItem(1);
    },

    onRegistrationSaveButtonTap: function(button, e, options) {
        console.log('save user');
        var view = this.getRegistrationView();
        var user = view.getRecord();
        user.set(view.getValues());
        user.getProxy().setUrl(fishpickle.baseURL + 'rest/user');

        var errors = user.validate();
        if (errors.isValid()) {
            user.save({
                callback: function(records, operation, success) {
                    if (success) {
                        this.getMainAppView().setActiveItem(1);
                    } else {
                        Ext.Msg.alert('Registration was not successful.');
                    }
                }
            },
            this
            );
        } else {
            var msg = '';
            for (i=0; i<errors.length; i++) {
                var e = errors.items[i];
                if ('name' == e.getField()) {
                    msg += 'Name ' + e.getMessage() + '\n';
                } else if ('email' == e.getField()) {
                    msg += 'Email ' + e.getMessage() + '\n';
                } else if ('login' == e.getField()) {
                    msg += 'Login Name ' + e.getMessage() + '\n';
                } else if ('password' == e.getField()) {
                    msg += 'Password ' + e.getMessage() + '\n';
                }
            }
        }
    },

    onRegistrationViewActivate: function(container, newActiveItem, oldActiveItem, options) {
        console.log('prepare user model');
        var user = Ext.create('fishpickle.model.User', {login:'', displayName:'', email:'', password:''});
        this.getRegistrationView().setRecord(user);
    }

});
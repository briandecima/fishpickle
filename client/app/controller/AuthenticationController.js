/*
 * File: app/controller/AuthenticationController.js
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

Ext.define('fishpickle.controller.AuthenticationController', {
    extend: 'Ext.app.Controller',

    config: {
        refs: {
            mainAppView: 'mainappview',
            loginView: {
                selector: 'authenticationview',
                xtype: 'loginview'
            }
        },

        control: {
            "#LoginButton": {
                tap: 'onLoginButtonTap'
            },
            "#loadingitem": {
                activate: 'onLoadingViewActivate'
            },
            "#RegisterButton": {
                tap: 'onRegisterButtonTap'
            }
        }
    },

    onLoginButtonTap: function(button, e, options) {
        var loginFormData = this.getLoginView().getValues();
        this.doLogin(loginFormData.login, loginFormData.password);
    },

    onLoadingViewActivate: function(container, newActiveItem, oldActiveItem, options) {
        console.log('activating loading view');
        var configStore = Ext.getStore("ConfigStore");
        configStore.load({
            callback: function(records, operation, success) {
                if (success) {
                    fishpickle.baseURL = records[0].data.value;
                    this.doAutoLogin();
                } else {
                    this.navigateToLoginView();            
                }
            },
            scope: this
        });
    },

    onRegisterButtonTap: function(button, e, options) {
        this.getMainAppView().setActiveItem(3);
    },

    updateLocalSettings: function(userModel) {
        var localSettingsStore = Ext.getStore("LocalSettingsStore");
        localSettingsStore.removeAt(0);
        var m = Ext.create('fishpickle.model.User');
        m.setData(userModel);
        localSettingsStore.add(m);
        localSettingsStore.sync();
        fishpickle.currentUser = m;
    },

    doLogin: function(loginName, password) {
        //get the user by login name
        if (fishpickle.baseURL && loginName && password) {
            var userStore = Ext.getStore('UserStore');
            if (!userStore) {
                userStore = Ext.create('fishpickle.store.UserStore');
            }
            userStore.getProxy().setUrl(fishpickle.baseURL + 'rest/login/' + loginName);
            userStore.load({
                callback: function(records, operation, success) {
                    if (success) {
                        var serverUser = records[0].data;
                        if (serverUser && password == serverUser.password) {
                            this.updateLocalSettings(serverUser);
                            this.navigateToMyGroupsView();
                        } else {
                            this.navigateToLoginView();
                            Ext.Msg.alert('Error', 'The password is invalid.  Please try again.');
                        }
                    } else {
                        this.navigateToLoginView();
                        Ext.Msg.alert('Error','The user name or password is invalid.  Please try again.');
                    }
                },
                scope: this
            });

        } else {
            //force user to login
            this.navigateToLoginView();
        }
    },

    navigateToLoginView: function() {
        this.getMainAppView().setActiveItem(1);
    },

    navigateToMyGroupsView: function() {
        this.getMainAppView().setActiveItem(2);
    },

    doAutoLogin: function() {
        var localSettingsStore = Ext.getStore("LocalSettingsStore");
        localSettingsStore.load({
            callback: function(records, operation, success) {
                if (success) {
                    var settings = localSettingsStore.getAt(0);
                    if (settings && settings.data && settings.data.login && settings.data.login.length > 0 && settings.data.password) {
                        this.doLogin(settings.data.login, settings.data.password);
                    } else {
                        this.navigateToLoginView();
                    }
                } else {
                    this.navigateToLoginView();
                }

            },
            scope: this
        });
    }

});
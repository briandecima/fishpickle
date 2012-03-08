/*
 * File: app/controller/GroupDetailsController.js
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

Ext.define('fishpickle.controller.GroupDetailsController', {
    extend: 'Ext.app.Controller',

    config: {
        stores: [
            'MyGroupsStore'
        ],
        refs: {
            groupDetailsView: 'groupdetailsview',
            mainAppView: 'mainappview',
            joinGroupButton: '#joinGroupButton',
            alreadyMemberLabel: '#alreadyMemberLabel'
        },

        control: {
            "#saveGroupButton": {
                tap: 'onSaveButtonTap'
            },
            "#myGroupsList": {
                disclose: 'onMyGroupsListDisclose'
            },
            "#searchResultsList": {
                disclose: 'onSearchResultsListDisclose'
            },
            "#groupDetailsBackButton": {
                tap: 'onBackButtonTap'
            },
            "#joinGroupButton": {
                tap: 'onJoinGroupButtonTap'
            }
        }
    },

    onSaveButtonTap: function(button, e, options) {
        var group = this.getGroupDetailsView().getRecord();
        group.set(this.getGroupDetailsView().getValues());
        if (group.data.id === null) {
            group.getProxy().setUrl(fishpickle.baseURL + 'rest/user/' + fishpickle.currentUser.data.id + '/groups');
        } else {
            group.getProxy().setUrl(fishpickle.baseURL + 'rest/group/');
        }


        group.save({
            callback: function(records, operation, success) {
                this.getMainAppView().setActiveItem(2);
            }
        },
        this
        );
    },

    onMyGroupsListDisclose: function(list, record, target, index, e, options) {
        this.openGroupDetails(record);
    },

    onSearchResultsListDisclose: function(list, record, target, index, e, options) {
        this.openGroupDetails(record);
    },

    onBackButtonTap: function(button, e, options) {
        this.getMainAppView().setActiveItem(2);
    },

    onJoinGroupButtonTap: function(button, e, options) {
        var group = this.getGroupDetailsView().getRecord();
        var assoc = Ext.create('fishpickle.model.UserGroupAssociations', { id: '', userId: fishpickle.currentUser.data.id, groupId: group.data.id });


        assoc.getProxy().setUrl(fishpickle.baseURL + 'rest/userGroupAssociation/');


        assoc.save({
            callback: function(records, operation, success) {
                Ext.Msg.alert('Success', 'You are now part of ' + group.data.name + ". ");
                this.getMainAppView().setActiveItem(2);

            }
        },
        this
        );
    },

    openGroupDetails: function(record) {
        this.getGroupDetailsView().setRecord(record);
        this.getMainAppView().setActiveItem(4);

        if (fishpickle.baseURL && fishpickle.currentUser) {
            //console.log("Panel Active Item Change " + fishpickle.baseURL);
            Ext.getStore("UserGroupAssociationStore").getProxy().setUrl(fishpickle.baseURL + "rest/userGroupAssociation/");
            Ext.getStore("UserGroupAssociationStore").load({
                callback: function(records, operation, success) {
                    if (success) {
                        this.handleAssociationDisplay(record);
                    } else {
                        console.log("Could not retrieve user associations");
                    }

                },
                scope: this

            } );  
        }
    },

    handleAssociationDisplay: function(group) {
        var store = Ext.getStore("UserGroupAssociationStore");
        store.clearFilter();
        store.filter([
        {filterFn: function(item) { 
            return (item.get("user").id == fishpickle.currentUser.data.id) && (item.get("group").id == group.data.id); 
        }}
        ]);

        var alreadyMember = store.getData().length > 0;
        this.getJoinGroupButton().setHidden(alreadyMember);
        this.getAlreadyMemberLabel().setHidden(!alreadyMember);
    }

});
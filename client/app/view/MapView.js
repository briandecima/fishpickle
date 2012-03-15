/*
 * File: app/view/MapView.js
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

Ext.define('fishpickle.view.MapView', {
    extend: 'Ext.form.Panel',
    alias: 'widget.mapview',

    config: {
        items: [
            {
                xtype: 'titlebar',
                docked: 'top',
                items: [
                    {
                        xtype: 'button',
                        id: 'removePinButton',
                        ui: 'action',
                        text: 'Clear Map',
                        align: 'right'
                    },
                    {
                        xtype: 'button',
                        id: 'getDirectionsButton',
                        ui: 'action',
                        text: 'Get Directions',
                        align: 'right'
                    }
                ]
            },
            {
                xtype: 'container',
                cls: [
                    'titleContainer'
                ],
                items: [
                    {
                        xtype: 'label',
                        html: '<h2>Location</h2>',
                        id: 'locationLabel'
                    }
                ]
            },
            {
                xtype: 'fieldset',
                baseCls: 'fieldSetHeader',
                cls: [
                    'formFieldSet'
                ],
                id: 'locationFieldSet',
                items: [
                    {
                        xtype: 'textfield',
                        id: 'mapOrigin',
                        inputCls: 'fieldSetField',
                        label: 'Origin',
                        labelCls: 'fieldSetLabel',
                        name: 'origin'
                    },
                    {
                        xtype: 'textfield',
                        id: 'mapDestination',
                        inputCls: 'fieldSetField',
                        label: 'Destination',
                        labelCls: 'fieldSetLabel',
                        name: 'destination'
                    },
                    {
                        xtype: 'selectfield',
                        inputCls: 'fieldSetField',
                        label: 'Travel By',
                        labelCls: 'fieldSetLabel',
                        value: [
                            {
                                value: 'W',
                                name: 'Walking'
                            }
                        ],
                        options: [
                            {
                                value: 'W',
                                text: 'Walking'
                            },
                            {
                                value: 'D',
                                text: 'Driving'
                            },
                            {
                                value: 'B',
                                text: 'Bicycling'
                            }
                        ]
                    }
                ]
            },
            {
                xtype: 'map',
                cls: [
                    'mapContainer'
                ],
                height: 300,
                id: 'map',
                itemId: 'map',
                useCurrentLocation: true
            },
            {
                xtype: 'container',
                cls: [
                    'messageContainer'
                ]
            }
        ]
    }

});
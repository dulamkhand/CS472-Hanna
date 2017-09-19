(function () {
    // products data
    var gems = [{
        name: 'Dodecahedron',
        price: 2.95,
        description: 'This beautifully crafted pouch doubles as both an everyday wallet and night-time clutch. It\'s the perfect size to fit all your essentials.',
        created: 20170112,
        canPurchase: true,
        soldOut: false,
        images: [{
            'full': 'd1.jpg',
            'thumb': 'd1-100.jpg',
        }, {
            'full': 'd2.jpg',
            'thumb': 'd2-100.jpg',
        }]
    },
    {
        name: 'Azurite',
        price: 5.95,
        description: 'Crafted in the softest leather with customised studded zip.',
        created: 20170112,
        canPurchase: true,
        soldOut: false,
        images: [{
            'full': 'a1.jpg',
            'thumb': 'a1-100.jpg',
        }, {
            'full': 'a2.jpg',
            'thumb': 'a2-100.jpg',
        }]
    },
    {
        name: 'Bloodstone',
        price: 4.05,
        description: 'Crafted in the softest leather with customised studded zip.',
        created: 20170112,
        canPurchase: true,
        soldOut: false,
        images: [{
            'full': 'b1.jpg',
            'thumb': 'b1-100.jpg',
        }, {
            'full': 'b2.jpg',
            'thumb': 'b2-100.jpg',
        }]
    },
    {
        name: 'Zircon',
        price: 3.05,
        description: 'Crafted in the softest leather with customised studded zip.',
        created: 20170112,
        canPurchase: true,
        soldOut: false,
        images: [{
            'full': 'z1.jpg',
            'thumb': 'z1-100.jpg',
        }, {
            'full': 'z2.jpg',
            'thumb': 'z2-100.jpg',
        }]
    }
    ]

    // application
    var app = angular.module('store', []);

    // module
    app.controller('StoreController', function () {
        this.products = gems;
    });


})();


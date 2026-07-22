const ctx = document.getElementById('expenseChart');

new Chart(ctx, {

    type: 'line',

    data: {

        labels: ['Jan','Feb','Mar','Apr','May','Jun'],

        datasets:[{

            label:'Expenses',

            data:[1000,1800,1200,2500,2000,3200],

            fill:true,

            tension:.4

        }]

    }

});
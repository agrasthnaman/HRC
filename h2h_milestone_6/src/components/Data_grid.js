import React, { useEffect, useState } from 'react';
import { DataGrid } from '@mui/x-data-grid';
import axios from 'axios';

import './styles.css'; // Import the CSS file with custom styles

const UserTable = () => {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get('http://localhost:8080/h2h_milestone_3_1/FetchAllUsers');
                // Add unique ID field to each user object
                const usersWithId = response.data.map((user, index) => ({ ...user, id: index + 1 }));
                setUsers(usersWithId);
            } catch (error) {
                console.error(error);
            }
        };

        fetchData();
    }, []);

    const columns = [
        { field: 'id', headerName: 'SL No', width: 50 },
        { field: 'customerOrderID', headerName: 'Customer Order Id', width: 150 },
        { field: 'salesOrg', headerName: 'Sales Org', width: 100 },
        { field: 'distributionChannel', headerName: 'Distribution Channel', width: 200 },
        { field: 'companyCode', headerName: 'Company Code', width: 150 },
        { field: 'orderCreationDate', headerName: 'Order Creation Date', width: 200 },
        { field: 'orderCurrency', headerName: 'Order Currency', width: 150 },
        { field: 'customerNumber', headerName: 'Customer Number', width: 150 },
        { field: 'amountUSD', headerName: 'Amount in USD', width: 180 },
        // { field: 'orderAmount', headerName: 'Order Amount', width: 150 },
    ];

    return (
        <div className="table-container">
            <DataGrid
                className="custom-data-grid" // Apply the custom CSS class
                rows={users}
                columns={columns}
                pageSize={10}
                checkboxSelection
                disableSelectionOnClick
                initialState={{
                    pagination:{
                        paginationModel:{pageSize:10,page:0},
                    },
                }}
            />
        </div>
    );
};

export default UserTable;

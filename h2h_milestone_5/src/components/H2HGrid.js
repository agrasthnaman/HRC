import React, { useState } from "react";
import data from "../data/Data";
import "../App.css";

const H2HGrid = () => {
  const [selectAll, setSelectAll] = useState(false);
  const [selectedRows, setSelectedRows] = useState([]);

  const handleCheckboxChange = (event, index) => {
    const isChecked = event.target.checked;
    if (index === -1) {
      // Checkbox in the header row is clicked
      setSelectAll(isChecked);
      setSelectedRows(isChecked ? data.map((_, index) => index) : []);
    } else {
      // Checkbox in a row is clicked
      setSelectedRows((prevSelectedRows) => {
        const updatedSelectedRows = [...prevSelectedRows];
        if (isChecked) {
          updatedSelectedRows.push(index);
        } else {
          const indexToRemove = updatedSelectedRows.indexOf(index);
          if (indexToRemove > -1) {
            updatedSelectedRows.splice(indexToRemove, 1);
          }
        }
        return updatedSelectedRows;
      });
      setSelectAll(selectedRows.length === data.length - 1);
    }
  };

  const isRowSelected = (index) => selectedRows.includes(index);

  return (
    <div>
      <table>
        <thead>
          <tr id="heading">
            <th>
              <label className="checkbox-container">
                <input
                  type="checkbox"
                  checked={selectAll}
                  onChange={(e) => handleCheckboxChange(e, -1)}
                />
              </label>
            </th>
            <th>SL NO</th>
            <th>CUSTOMER ORDER ID</th>
            <th>SALES ORG</th>
            <th>DISTRIBUTION CHANNEL</th>
            <th>COMPANY CODE</th>
            <th>ORDER CREATION DATE</th>
            <th>ORDER AMOUNT</th>
            <th>ORDER CURRENCY</th>
            <th>CUSTOMER NUMBER</th>
            <th>AMOUNT_IN_USD</th>
          </tr>
        </thead>
        <tbody>
          {data.map((props, index) => (
            <tr key={props.CustomerOrderId}>
              <td>
                <label className="checkbox-container">
                  <input
                    type="checkbox"
                    checked={isRowSelected(index)}
                    onChange={(e) => handleCheckboxChange(e, index)}
                  />
                </label>
              </td>
              <td>{props.SlNo}</td>
              <td>{props.CustomerOrderId}</td>
              <td>{props.SalesOrg}</td>
              <td>{props.DistributionChannel}</td>
              <td>{props.CompanyCode}</td>
              <td>{props.OrderCreationDate}</td>
              <td>{props.OrderAmount}</td>
              <td>{props.OrderCurrency}</td>
              <td>{props.CustomerNumber}</td>
              <td>{props.AmountInUSD}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default H2HGrid;

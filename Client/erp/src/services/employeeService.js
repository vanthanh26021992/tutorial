import axios from "axios";
import { CONFIG } from "../ultils/constants";

const EmployeeService = {
  async getEmployee() {
    console.log("Get employee ");
    await axios
      .get(`${CONFIG.SERVER}/getAllEmployee`)
      .then(function (response) {
        return response.data;
      })
      .catch(function (error) {});
  },
};

export default EmployeeService;

// const getEmployee = () => {
//   console.log("Get employee ");
//   axios
//     .get(`${CONFIG.SERVER}/getAllEmployee`)
//     .then(function (response) {
//       setData(response.data);
//     })
//     .catch(function (error) {});
// };

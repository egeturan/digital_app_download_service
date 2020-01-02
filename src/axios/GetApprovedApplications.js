import React from 'react';
import axios from 'axios';

function GetApprovedApplications(props) {

  console.log(props.value);

  axios.get(`http://localhost:3000/get_approved_applications`)
      .then(res => {
        let apps = []
        apps = res.data;
        console.log(apps);
      })

  return <div></div>;
}

export default GetApprovedApplications;
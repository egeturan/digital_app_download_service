import React from 'react';
import axios from 'axios';

function GetMinReq(props) {

  console.log(props.value);

  const app = {
    app_id: props.app_id
  }

  axios.post(`http://localhost:8080/get_min_req/`, app )
      .then(res => {
        console.log(res);
        console.log(app);
        
      })

  return <div></div>;
}

export default GetMinReq;
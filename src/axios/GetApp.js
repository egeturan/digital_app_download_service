import React from 'react';
import axios from 'axios';

function GetApp(props) {

  console.log(props.value);

  const app = {
    app_id: props.app_id
  }

  axios.post(`http://localhost:8080/get_app/`, app )
      .then(res => {
        console.log(res);
        console.log(app);
        
      })

  return <div></div>;
}

export default GetApp;
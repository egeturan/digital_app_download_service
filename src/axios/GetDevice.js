import React from 'react';
import axios from 'axios';

function GetDevice(props) {

  console.log(props.value);

  const device = {
    device_id: props.device_id
  }

  axios.post(`http://localhost:8080/add_devices/`, device )
      .then(res => {
        console.log(res);
        console.log(device);
        
      })

  return <div></div>;
}

export default GetDevice;
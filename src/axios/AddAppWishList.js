import React from 'react';
import axios from 'axios';

function AddAppWishList(props) {

  console.log(props.value);

  const wish = {
    user_id: props.user_id,
    app_name: props.app_name
  }

  axios.post(`http://localhost:8080/add_app_wish_list/`, wish )
      .then(res => {
        console.log(res);
        console.log(wish);
        
      })

  return <div></div>;
}

export default AddAppWishList;
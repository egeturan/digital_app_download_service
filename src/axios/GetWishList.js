import React from 'react';
import axios from 'axios';

function GetWishList(props) {

    const wish = {
        user_id: props.user_id
      }

      axios.post(`http://localhost:8080/get_wish_list/`, wish )
      .then(res => {
        let apps = [];
        apps = res.data;
        console.log(apps);
      })

  return <div></div>;
}

export default GetWishList;

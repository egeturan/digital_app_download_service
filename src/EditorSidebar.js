import React, {AllHTMLAttributes as classes} from "react";
import GLOBAL from './global';
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import DashboardIcon from '@material-ui/icons/Dashboard';
import ShoppingCartIcon from '@material-ui/icons/ShoppingCart';
import PeopleIcon from '@material-ui/icons/People';
import BarChartIcon from '@material-ui/icons/BarChart';
import LayersIcon from '@material-ui/icons/Layers';
import ArrowDropDownIcon from '@material-ui/icons/ArrowDropDown';
import ArrowDropUpIcon from '@material-ui/icons/ArrowDropUp';
import AssignmentIcon from '@material-ui/icons/Assignment';
import ListItemText from "@material-ui/core/ListItemText";
import {Collapse} from "@material-ui/core";
import Divider from "@material-ui/core/Divider";


class EditorSidebar extends React.Component {
    state = {
        showDisplay: 0,
        authenticate: 1,
        user: GLOBAL.userG,
        submenu: false
    }

    displayer(number) {
        this.setState({
            showDisplay: number
        });
    }

    handleClick() {
        if (this.state.submenu == true) {
            this.setState({
               submenu: false
            });
        }
        else {
            this.setState({
                submenu: true
            });
        }
    }

    render() {

        const sidebar = (
            <div style={{overflowX : 'auto', fontSize: '20px', left: "0px", position: "fixed", alignSelf: "flex-end", width:"300px", height:"auto", top:"120px", backgroundColor: "white"}}>
                <ListItem button>
                    <ListItemIcon>
                        <DashboardIcon />
                    </ListItemIcon>
                    <ListItemText primary="Dashboard" />
                </ListItem>

                <ListItem button onClick={this.handleClick.bind(this)}>
                    <ListItemIcon>
                        {this.state.submenu ? <ArrowDropUpIcon /> : <ArrowDropDownIcon />}
                    </ListItemIcon>
                    <ListItemText primary="Editor Actions" />
                </ListItem>
                <Collapse in={this.state.submenu} timeout="auto" unmountOnExit>
                    <Divider />
                    <ListItem button style={{marginLeft: "15px"}}>
                        <ListItemText primary="See Application Requests" />
                    </ListItem>
                    <ListItem button>
                        <ListItemText primary="See Update Requests" />
                    </ListItem>
                    <ListItem button>
                        <ListItemText primary="Manage Books" />
                    </ListItem>
                    <ListItem button>
                        <ListItemText primary="Manage Movies" />
                    </ListItem>
                </Collapse>
                <ListItem button>
                    <ListItemIcon>
                        <PeopleIcon />
                    </ListItemIcon>
                    <ListItemText primary="Customers" />
                </ListItem>
                <ListItem button>
                    <ListItemIcon>
                        <BarChartIcon />
                    </ListItemIcon>
                    <ListItemText primary="Reports" />
                </ListItem>
                <ListItem button>
                    <ListItemIcon>
                        <LayersIcon />
                    </ListItemIcon>
                    <ListItemText primary="Integrations" />
                </ListItem>
            </div>
        );

        return (
            <div>
                {sidebar}
            </div>
        );
    };
}

export default EditorSidebar;
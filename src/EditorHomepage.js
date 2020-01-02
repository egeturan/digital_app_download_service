import React, {AllHTMLAttributes as classes} from "react";
import GLOBAL from './global';
import ListItem from "@material-ui/core/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import DashboardIcon from '@material-ui/icons/Dashboard';
import ArrowDropDownIcon from '@material-ui/icons/ArrowDropDown';
import ArrowDropUpIcon from '@material-ui/icons/ArrowDropUp';
import ListItemText from "@material-ui/core/ListItemText";
import {Collapse} from "@material-ui/core";
import Divider from "@material-ui/core/Divider";
import PersonIcon from '@material-ui/icons/Person';
import SettingsIcon from '@material-ui/icons/Settings';
import {Button, Grid} from "semantic-ui-react";
import HomePage2 from "./Homepage2";
import GetApprovedApplications from "./axios/GetApprovedApplications";
import MakeApprovement from "./MakeApprovement";
import MakeUpdateApprovement from "./MakeUpdateApprovement";


class EditorHomepage extends React.Component {
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

    handleSubmenuClick() {
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
            <div style={{overflowX : 'auto', fontSize: '20px', left: "0px", position: "fixed", alignSelf: "flex-end", width:"auto", height:"auto", top:"120px", backgroundColor: "white"}}>
                <ListItem button onClick={this.displayer.bind(this, 0)}>
                    <ListItemIcon>
                        <DashboardIcon />
                    </ListItemIcon>
                    <ListItemText primary="Dashboard" />
                </ListItem>

                <ListItem button onClick={this.handleSubmenuClick.bind(this)}>
                    <ListItemIcon>
                        {this.state.submenu ? <ArrowDropUpIcon /> : <ArrowDropDownIcon />}
                    </ListItemIcon>
                    <ListItemText primary="Editor Actions" />
                </ListItem>
                <Collapse in={this.state.submenu} timeout="auto" unmountOnExit>
                    <Divider />
                    <ListItem button style={{marginLeft: "15px"}} onClick={this.displayer.bind(this, 1)}>
                        <ListItemText primary="See Application Requests" />
                    </ListItem>
                    <ListItem button style={{marginLeft: "15px"}} onClick={this.displayer.bind(this, 2)}>
                        <ListItemText primary="See Update Requests" />
                    </ListItem>
                    <ListItem button style={{marginLeft: "15px"}} onClick={this.displayer.bind(this, 3)}>
                        <ListItemText primary="Manage Books" />
                    </ListItem>
                    <ListItem button style={{marginLeft: "15px"}} onClick={this.displayer.bind(this, 4)}>
                        <ListItemText primary="Manage Movies" />
                    </ListItem>
                </Collapse>
                <ListItem button>
                    <ListItemIcon>
                        <PersonIcon />
                    </ListItemIcon>
                    <ListItemText primary="Profile" />
                </ListItem>
                <ListItem button>
                    <ListItemIcon>
                        <SettingsIcon />
                    </ListItemIcon>
                    <ListItemText primary="Settings" />
                </ListItem>
            </div>
        );

        const applicationRequests = (
            <p>
                <MakeApprovement></MakeApprovement>
            </p>
        );

        const updateRequests = (
            <p>
                <MakeUpdateApprovement></MakeUpdateApprovement>
            </p>
        );

        const manageBooks = (
            <p>
                Books
            </p>
        );

        const manageMovies = (
            <p>
                Movies
            </p>
        );

        let displayer = null;


        if(this.state.showDisplay == 0){
            displayer = (

            <div>
                <Grid>
                    <Grid.Column style={{}}>
                        {sidebar}
                    </Grid.Column>

                    <Grid.Column style={{width: "auto", marginLeft: "260px"}}>
                        <HomePage2></HomePage2>
                    </Grid.Column>
                </Grid>
            </div>
            );
            console.log(this.state.user);
        }
        else if(this.state.showDisplay == 1){
            displayer = (
                <div>
                    <Grid>
                        <Grid.Column style={{}}>
                            {sidebar}
                        </Grid.Column>

                        <Grid.Column style={{width: "auto", marginLeft: "260px"}}>
                            {applicationRequests}
                        </Grid.Column>
                    </Grid>
                </div>
            );
        }
        else if(this.state.showDisplay == 2) {
            displayer = (
                <div>
                    <Grid>
                        <Grid.Column style={{}}>
                            {sidebar}
                        </Grid.Column>

                        <Grid.Column style={{width: "auto", marginLeft: "260px"}}>
                            {updateRequests}
                        </Grid.Column>
                    </Grid>
                </div>
            );
        }
        else if(this.state.showDisplay == 3) {
            displayer = (
                <div>
                    <Grid>
                        <Grid.Column style={{}}>
                            {sidebar}
                        </Grid.Column>

                        <Grid.Column style={{width: "auto", marginLeft: "260px"}}>
                            {manageBooks}
                        </Grid.Column>
                    </Grid>
                </div>
            );
        }
        else if(this.state.showDisplay == 4) {
            displayer = (
                <div>
                    <Grid>
                        <Grid.Column style={{}}>
                            {sidebar}
                        </Grid.Column>

                        <Grid.Column style={{width: "auto", marginLeft: "260px"}}>
                            {manageMovies}
                        </Grid.Column>
                    </Grid>
                </div>
            );
        }

        return (

            <div>
                {displayer}
            </div>
        );
    };
}

export default EditorHomepage;
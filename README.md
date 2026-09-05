# Mini Hospital Emergency Management System

## Overview
This is a Java console application that simulates a Mini Hospital Emergency Management System. It manages patient registration, emergency treatment requests, treatment completion, and patient visit history using core data structures.

## Data Structures Used

### 1. Binary Search Tree (BST)
Used to store patient records with Patient ID as the key.
- Insert a new patient
- Search for a patient by ID
- Delete a patient
- Inorder traversal to display patients in ascending order of ID

### 2. Queue
Used to manage patients waiting in the emergency unit (FIFO).
- Enqueue - add a patient to the waiting list
- Dequeue - remove the next patient for treatment
- Display waiting patients
- Handles empty queue

### 3. Stack
Used to store completed treatment records (LIFO).
- Push - add a completed treatment record
- Pop - remove the most recent treatment record
- Display treatment history
- Handles empty stack

### 4. Singly Linked List
Used to maintain each patient's visit history.
- Add a new visit
- Remove a visit
- Search for a visit
- Display visit history

## Project Structure